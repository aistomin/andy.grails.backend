import requests
import os
import sys

USERNAME = "andygrails"
REPO = "andy-grails-backend"
KEEP = 10  # number of latest tags to keep

# This is your Docker Hub personal access token (or org token) from GitHub Secrets
DOCKER_HUB_TOKEN = os.environ["DOCKER_HUB_ACCESS_TOKEN"]

# --- Step 1: Exchange PAT for a short-lived Bearer token ---
print("🔑 Logging in to Docker Hub...")
login_resp = requests.post(
    "https://hub.docker.com/v2/users/login/",
    json={"username": USERNAME, "password": DOCKER_HUB_TOKEN},
)
if login_resp.status_code != 200:
    print(f"❌ Login failed: {login_resp.status_code} {login_resp.text}")
    sys.exit(1)

bearer_token = login_resp.json()["token"]
headers = {"Authorization": f"Bearer {bearer_token}"}

# --- Step 2: Fetch tags ---
print(f"🧹 Cleaning up {REPO}...")
url = f"https://hub.docker.com/v2/repositories/{USERNAME}/{REPO}/tags?page_size=100"
tags = []

while url:
    r = requests.get(url, headers=headers)
    r.raise_for_status()
    data = r.json()
    tags.extend(data.get("results", []))
    url = data.get("next")

if not tags:
    print("⚠️  No tags found or API returned empty list.")
    sys.exit(0)

# --- Step 3: Sort by last_updated and delete old ones ---
tags.sort(key=lambda t: t["last_updated"], reverse=True)
to_delete = tags[KEEP:]

print(f"Keeping {KEEP} most recent tags. Deleting {len(to_delete)} older tags...\n")

for tag in to_delete:
    tag_name = tag["name"]
    delete_url = f"https://hub.docker.com/v2/repositories/{USERNAME}/{REPO}/tags/{tag_name}/"
    print(f"🗑️  Deleting {REPO}:{tag_name} ... ", end="")
    del_resp = requests.delete(delete_url, headers=headers)
    if del_resp.status_code in (204, 202):
        print("✅")
    else:
        print(f"⚠️  Failed ({del_resp.status_code})")

print("\n✅ Cleanup completed!")

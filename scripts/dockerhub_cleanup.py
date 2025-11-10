import requests
import os

USERNAME = "andygrails"
REPO = "andy-grails-backend"
KEEP = 10  # number of latest tags to keep

# This is your Docker Hub personal access token (used as password)
PASSWORD = os.environ["DOCKER_HUB_ACCESS_TOKEN"]

# Step 1: Exchange Docker Hub token for a *registry-scoped bearer token*
print("🔑 Getting Docker Hub registry token...")
auth_url = (
    f"https://auth.docker.io/token?service=registry.docker.io"
    f"&scope=repository:{USERNAME}/{REPO}:*"
)
auth_resp = requests.get(auth_url, auth=(USERNAME, PASSWORD))
auth_resp.raise_for_status()
bearer_token = auth_resp.json()["token"]
headers = {"Authorization": f"Bearer {bearer_token}"}

# Step 2: Get tags and clean up
print(f"🧹 Cleaning up {REPO}...")
url = f"https://hub.docker.com/v2/repositories/{USERNAME}/{REPO}/tags?page_size=100"
tags = []

while url:
    r = requests.get(url, headers=headers)
    r.raise_for_status()
    data = r.json()
    tags.extend(data["results"])
    url = data.get("next")

tags.sort(key=lambda t: t["last_updated"], reverse=True)

for tag in tags[KEEP:]:
    tag_name = tag["name"]
    delete_url = f"https://hub.docker.com/v2/repositories/{USERNAME}/{REPO}/tags/{tag_name}/"
    print(f"🗑️  Deleting {REPO}:{tag_name} ... ", end="")
    del_resp = requests.delete(delete_url, headers=headers)
    if del_resp.status_code in (202, 204):
        print("✅ Deleted")
    else:
        print(f"⚠️  Failed ({del_resp.status_code}) {del_resp.text}")

print("✅ Cleanup completed!")

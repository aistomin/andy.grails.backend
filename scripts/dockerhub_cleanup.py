import requests
import os

USERNAME = "andygrails"
REPO = "andy-grails-backend"
KEEP = 10  # number of latest tags to keep
TOKEN = os.environ["DOCKERHUB_TOKEN"]

headers = {"Authorization": f"Bearer {TOKEN}"}

print(f"🧹 Cleaning up {REPO}...")
url = f"https://hub.docker.com/v2/repositories/{USERNAME}/{REPO}/tags?page_size=100"
tags = []
while url:
    r = requests.get(url, headers=headers)
    data = r.json()
    tags.extend(data["results"])
    url = data.get("next")
tags.sort(key=lambda t: t["last_updated"], reverse=True)
for tag in tags[KEEP:]:
    tag_name = tag["name"]
    delete_url = f"https://hub.docker.com/v2/repositories/{USERNAME}/{REPO}/tags/{tag_name}/"
    print(f"Deleting {REPO}:{tag_name}")
    requests.delete(delete_url, headers=headers)
print("✅ Cleanup completed!")

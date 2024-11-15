### running mongo in local
```bash
docker run -d --name mongodb -p 27017:27017 -v ~/Desktop/m-chord/dump/mongo:/data/db mongo:latest
docker exec -it mongodb mongosh

# connection string
mongodb://localhost:27017/localDB
```
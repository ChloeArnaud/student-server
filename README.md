# student-server
Cloud integration personal project

Commands to execute :
Build : ./gradlew build
Launch : ./gradlew bootrun

To launch the server locally: 
./gradlew bootJar
java -jar filepath

To launch the server on docker
Create the dockerfile
docker build --tag=server:latest .
docker run -d -p 8080:8080 server

Using minikube : 

minikube start --driver=docker
minikube status

et après les commandes sont executées avec kubectl : 
kubectl get pods
kubectl get deployment
kubectl get nodes
kubectl get services
kubectl create deployement server-depl --image=server:latest
kubectl get replicaset


kubectl deployment server-depl <- si besoin de supprimer

kubectl logs server-depl-xxxx (numéros que je sais pas où on récupère)

kubectl create deployment nginx-depl --image=nginx
kubectl edit deployment nginx-depl -> Edit the spec : replicas part. 

kubectl apply -f ./k8s/nomdemonfichier.yaml
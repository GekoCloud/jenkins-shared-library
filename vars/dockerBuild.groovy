def call(String registry, String user, String pass, String image, String tag) {
  dockerImage = "${registry}/${image}:${tag}"

  sh '''
    docker image build -t ${dockerImage} .
    docker login ${registry} -u '${user}' -p '${pass}'
    docker image push ${dockerImage}
  '''
}

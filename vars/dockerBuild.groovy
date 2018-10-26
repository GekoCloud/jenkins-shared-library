def call(String registry, String user, String pass, String image, String tag) {
  def docker_image = "${registry}/${image}:${tag}"

  sh '''
    docker image build -t ${docker_image} .
    docker login ${registry} -u '${user}' -p '${pass}'
    docker image push ${docker_image}
  '''
}

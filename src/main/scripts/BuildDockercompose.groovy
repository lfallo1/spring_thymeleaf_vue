String template = new File("${project.basedir}/src/main/docker/DockerComposeTemplate".toString()).getText()

def imageTag = project.properties['git.commit.id.abbrev']
def dockerFileText = new groovy.text.SimpleTemplateEngine().createTemplate(template)
        .make([gitCommit: imageTag])

println "writing file " + "${project.basedir}/src/main/docker/compose/docker-compose.yml"
File dockerFile = new File("${project.basedir}/src/main/docker/compose/docker-compose.yml".toString())

dockerFile.withWriter('UTF-8') { writer ->
    writer.write(dockerFileText)
}
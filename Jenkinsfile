pipeline {
    agent any
    stages {
        stage('Clonar') {
            steps {
                git 'https://github.com/claudiaPenaR/MyConstruccion.git'
            }
        }
        stage('Construir WAR') {
            steps {
                script {
                    bat 'mvn clean install'
                }
            }
        }
        stage('Archivar WAR') {
            steps {
                archiveArtifacts allowEmptyArchive: true, artifacts: 'target/*.war'
            }
        }
        stage('Subir a Artifactory') {
            steps {
                script {
                    // Configuración para subir el artefacto a Artifactory
                    def server = Artifactory.server 'Artifacty' // Cambia 'my-artifactory-server-id' por el ID configurado en Jenkins
                    
                    // Define las especificaciones de subida
                    def uploadSpec = """{
                        "files": [
                            {
                                "pattern": "target/*.war",
                                "target": "MyContruccionRep"
                            }
                        ]
                    }"""

                    // Sube el artefacto
                    server.upload spec: uploadSpec
                }
            }
        }
    }
}

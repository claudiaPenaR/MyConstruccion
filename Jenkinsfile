groovy
Copiar código
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
                    sh 'mvn clean install'
                }
            }
        }
        stage('Archivar WAR') {
            steps {
                archiveArtifacts allowEmptyArchive: true, artifacts: 'target/*.war'
            }
        }
    }
}

pipeline {
    agent any
    
    tools {
        maven 'Maven3'
    }
    
    environment {
        GITHUB_REPO = 'https://github.com/claudiaPenaR/MyConstruccion.git'
        ARTIFACTORY_URL = 'http://localhost:8082/artifactory'
        WAR_FILE = 'my-construccion-0.0.1-SNAPSHOT.war'
    }
    
    stages {
        stage('Clean Workspace') {
            steps {
                script {
                    // Limpiar workspace de forma segura
                    bat 'if exist * del /F /Q *'
                    bat 'for /d %%i in (*) do rd /s /q "%%i"'
                    bat 'if exist .git rd /s /q .git'
                }
            }
        }
        
        stage('Checkout') {
            steps {
                bat "git clone ${GITHUB_REPO} ."
            }
        }
        
        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
        
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Deploy to Artifactory') {
            steps {
                script {
                    // Usar el nombre correcto del archivo WAR
                    bat """
                        curl -u admin1978:Admin1978/ -X PUT "http://localhost:8082/artifactory/MyConstruccionRep/my-construccion-0.0.1-SNAPSHOT.war" -T "target/my-construccion-0.0.1-SNAPSHOT.war"

                    """
                }
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline ejecutado exitosamente!'
            archiveArtifacts artifacts: "target/${WAR_FILE}", fingerprint: true
        }
        failure {
            echo 'Pipeline falló'
        }
    }
}

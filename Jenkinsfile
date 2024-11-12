pipeline {
    agent any
    
    tools {
        maven 'Maven3'
    }
    
    environment {
        GITHUB_REPO = 'https://github.com/claudiaPenaR/MyConstruccion.git'
    }
    
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Testing...'
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
} // Cierre del bloque pipeline

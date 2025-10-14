pipeline {
    agent any
    tools {
        maven 'MAVEN_HOME' // aqui deve ser o mesmo nome que colocaste no Jenkins
    }


    stages {
        stage('Build') {
            steps {
                echo '🚀 A compilar o projeto...'
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Archive') {
            steps {
                echo '📦 A arquivar o pacote gerado...'
            }
        }
    }

    post {
        success {
            echo '✅ Build concluído com sucesso!'
        }
        failure {
            echo '❌ O build falhou.'
        }
    }
}

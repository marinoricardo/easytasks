pipeline {
    agent any
    tools {
        maven 'MAVEN_HOME'
    }

    environment {
        SERVICE_NAME = 'EasyTasks'
        SERVICE_PATH = 'C:\\Services\\EasyTasks'
        NSSM_PATH = 'C:\\Services\\nssm.exe'
        BACKUP_PATH = 'C:\\Services\\EasyTasks\\backup'
    }

    stages {
        stage('Deploy - Stop Service') {
            steps {
                echo '⏹ Parando o serviço EasyTasks...'
                bat "${NSSM_PATH} stop ${SERVICE_NAME}"
            }
        }

        stage('Build') {
            steps {
                echo '🚀 A compilar o projeto...'
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Deploy - Prepare Backup') {
            steps {
                echo '📦 Criando pasta de backup se não existir...'
                bat "powershell -Command \"if (!(Test-Path '${BACKUP_PATH}')) { New-Item -ItemType Directory -Path '${BACKUP_PATH}' }\""
            }
        }

stage('Deploy - Backup Old Jar') {
    steps {
        echo '💾 Fazendo backup do jar antigo com datetime...'
        bat """
        powershell -Command "\$date = Get-Date -Format 'yyyyMMdd_HHmmss'; \
        \$dest = Join-Path '${BACKUP_PATH}' ('easytasks_' + \$date + '.jar'); \
        Copy-Item -Path '${SERVICE_PATH}\\\\easytasks.jar' -Destination \$dest -Force"
        """
    }
}


        stage('Deploy - Copy New Jar') {
            steps {
                echo '📄 Copiando novo jar...'
                bat "powershell -Command \"Copy-Item -Path 'target\\\\*.jar' -Destination '${SERVICE_PATH}\\\\easytasks.jar' -Force\""
            }
        }


        stage('Deploy - Wait Before Start') {
            steps {
                echo '⏳ Esperando 1 minuto antes de iniciar o serviço...'
                bat "powershell -Command \"Start-Sleep -Seconds 30\""
                
            }
        }
        
    }

    post {
        always {
            echo '🔄 Garantindo que o serviço EasyTasks está iniciado...'
            bat "${NSSM_PATH} start ${SERVICE_NAME}"
        }
        success {
            echo '✅ Build e deploy concluídos com sucesso!'
        }
        failure {
            echo '❌ O build ou deploy falhou.'
        }
    }
}

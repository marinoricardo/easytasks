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
        stage('Build') {
            steps {
                echo '🚀 A compilar o projeto...'
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Deploy - Prepare Backup') {
            steps {
                echo '📦 Criando pasta de backup se não existir...'
                bat """
                powershell -Command "if (!(Test-Path '${BACKUP_PATH}')) { New-Item -ItemType Directory -Path '${BACKUP_PATH}' }"
                """
            }
        }

        stage('Deploy - Backup Old Jar') {
            steps {
                echo '💾 Fazendo backup do jar antigo com datetime...'
                bat """
                powershell -Command "\$date = Get-Date -Format 'yyyyMMdd_HHmmss'; \
                Copy-Item -Path '${SERVICE_PATH}\\\\easytasks.jar' -Destination '${BACKUP_PATH}\\\\easytasks_\$date.jar' -Force"
                """
            }
        }

        stage('Deploy - Stop Service') {
            steps {
                echo '⏹ Parando o serviço EasyTasks...'
                bat "${NSSM_PATH} stop ${SERVICE_NAME}"
            }
        }

        stage('Deploy - Copy New Jar') {
            steps {
                echo '📄 Copiando novo jar...'
                bat "powershell -Command \"Copy-Item -Path 'target\\\\*.jar' -Destination '${SERVICE_PATH}\\\\easytasks.jar' -Force\""
            }
        }
    //     stage('Deploy - Start Service') {
    // steps {
    //     echo '▶️ Reiniciando o serviço EasyTasks...'
    //     bat """
    //     powershell -Command "while ((Get-Service -Name '${SERVICE_NAME}').Status -ne 'Stopped') { Start-Sleep -Seconds 2 }; Start-Service -Name '${SERVICE_NAME}'"
    //     """
    // }
}


    }

    post {
        success {
            echo '✅ Build e deploy concluídos com sucesso!'
        }
        failure {
            echo '❌ O build ou deploy falhou.'
        }
    }
}

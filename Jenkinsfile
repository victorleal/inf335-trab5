pipeline {
    agent any

    tools {
        maven "M3"
    }

    steps {
        stage('Build') {
            git 'https://github.com/victorleal/inf335-trab5.git'

            sh 'mvn -Dmaven.test.failure.ignore=true clean package'
        }

        post {
            success {
                junit '**/target/surefire-reports/TEST-*.xml'
                archiveArtifacts 'target/*.jar'
            }
        }
    }
}

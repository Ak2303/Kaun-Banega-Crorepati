pipeline {
    agent {
        label 'android'
     }
    stages {
        stage('build') {
            steps {
                bat "echo 'Build Finish' "
            }
        }
        stage('Permissions') {

      steps {

        bat "echo '-------------------Asking for permissions--------------------'"

        bat 'dir -la .\gradlew'
        bat 'attrib +x .\gradlew'
        bat 'dir -la .\gradlew'
      }
      post {
        success {
          // Notify permissions granted
          bat "echo 'Permissions granted!!'"
        }
        failure {
          // Notify permissions denied
          bat "echo 'Oops!! Permissions denied.'"
        }
      }
    }
    }
}


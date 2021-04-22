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
        stage('Compile') {
              steps {
        bat "echo '-------------------Compiling App and its dependencies--------------------'"
        
        // Compile the app and its dependencies
        bat './gradlew compileDebugSources'
      }
      post {
        success {
          // Notify compile successful
          bat "echo 'App compiled successfully.'"
        }
        failure {
          // Notify compile failed
          bat "echo 'Compile failed!!'"
        }
      }
    }
        }

    }


pipeline {
  agent {

    label 'android'
  }

  stages {
    stage('Initializing'){
        steps{
            bat "echo 'Build started' "
        }
    }
    stage('Permissions') {

      steps {

        bat "echo 'Granting Permissions'"

        bat 'dir -la ./gradlew'
        bat 'attrib +x ./gradlew'
        bat 'dir -la ./gradlew'
      }
      post {
        success {
          //if successfully granted permissions
          bat "echo 'Permissions granted!!'"
        }
        failure {
          //if failed to grant permissions
          bat "echo 'Oops!! Permissions denied.'"
        }
      }
    }
    stage('Compile') {
      steps {
        bat "echo 'Compiling Application dependencies'"

        // Compile the app and its dependencies
        bat './gradlew compileDebugSources'
      }
      post {
        success {
          //if successfully compiled
          bat "echo 'App compiled successfully.'"
        }
        failure {
          //if compile failed
          bat "echo 'Compile failed!!'"
        }
      }
    }
    stage('Unit tests') {
      steps {
        bat "echo 'Running Unit Tests'"

        // Compile and run the unit tests for the app and its dependencies
        bat './gradlew testDebugUnitTest'

        // Rewriting previously written test results
        bat 'find . -name "TEST-*.xml" -exec touch {} \\;'

        // Analyse the test results and update the build result
        junit '**/TEST-*.xml'

      }
      post {
        success {
          // if tests successful
          bat "echo 'All tests passed successfully.'"
        }
        failure {
          // if tests failed
          bat "echo 'Some tests are failing.'"
        }
      }
    }
    stage('Build APK') {
      steps {
        bat "echo 'Building APK of the Application'"

        // Finish building and packaging the APK
        bat './gradlew assembleDebug'

        // Archive the APKs so that they can be downloaded from Jenkins
        archiveArtifacts '**/*.apk'
      }
      post {
        success {
          // if build successful
          bat "echo 'APK build successful'"
        }
        failure {
          // if build failed
          bat "echo 'APK build failed.'"
        }
      }
    }
    stage('Lint Check') {
      steps {
        bat "echo 'Running Lint checks'"

        // Run Lint and analyse the results
        bat './gradlew lintDebug'

      }
      post {
        success {
          // if lint checks successful
          bat "echo 'Lint checks successful.'"
        }
        failure {
          // if lint checks failed
          bat "echo 'Lint checks failed.'"
        }
      }
    }
    stage('Deploy') {

      steps {
        bat "echo 'Deploying APK'"

        // Build the app in release mode
        bat './gradlew assembleRelease'

        // Archive the APKs so that they can be downloaded from Jenkins
        archiveArtifacts '**/*.apk'

      }
      post {
        success {
          // Notify build succeeded
          bat "echo 'Congrqatulations! Build successful.'"
        }
      }
    }
  }
  post {
    failure {
      // Notify build failed
      bat "echo 'Oops! Build ${env.BUILD_NUMBER} failed; ${env.BUILD_URL}'"
    }
  }
}

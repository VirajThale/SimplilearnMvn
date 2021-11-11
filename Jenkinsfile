pipeline {
    agent any
    tools {
        
        maven "M2"
    }
    stages {
        
        stage('Preparation'){
            
            steps{
                // Get some code from a GitHub repository
                git 'https://github.com/VirajThale/SimplilearnMvn.git' 
            }
        }
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn test"
                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
    }
}
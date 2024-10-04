pipeline{
    agent any
    stages{
        stage('Build'){
            steps{
                echo "compile and package code with Maven"
            }
        }
        stage('Test'){
            steps{
                echo "Run unit tests with Mocha"
            }
        }
        stage('Analyse'){
            steps{
                echo "Analyse code using SonarQube"
            }
        }
        stage('Scan'){
            steps{
                echo "Perform security scan using Nessus"
            }
            post{
                success {
                    mail to: "tainemarkley@gmail.com",
                    subject: "Scan Status Email",
                    body: "Scan was succesful!"
                }
            }
        }
        stage('DeployStage'){
            steps{
                echo "Deploy application to staging server"
            }
        }
        stage('Test'){
            steps{
                echo "Run integration tests"
            }
            post{
                success{
                    mail to: "tainemarkley@gmail.com",
                    subject: "Test Status Email",
                    body: "Test was successful!"
                }
            }
        }
        stage('DeployProduction'){
            steps{
                echo "Deploy to production server"
            }
        }
        
    }
}
@Library('jenkinslibrary') _
pipeline{
    agent any

    stages{

        stage("Git Checkout"){
            steps{
                
                script{     
                    gitCheckout(
                        branch: "main",
                        url: "https://github.com/jithujijo/ci-cd-automation.git"
                    )
                }
            }
        }
        stage("Unit Test : Maven"){
            steps{
                
                script{     
                    mavenTest()
                }
            }
        }
        stage("Maven Integration Test : Maven"){
            steps{
                
                script{     
                    mavenTest()
                }
            }
        }
    }
    
}
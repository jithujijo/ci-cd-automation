@Library('jenkinslibrary') _
pipeline{
    agent any

    parameters{

        string(name: 'branch', description: "choose the branch", defaultValue: 'main')
    }

    stages{

        stage("Git Checkout"){
            steps{
                
                script{     
                    gitCheckout(
                        branch: ${params.branch},
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
                    mavenIntegrationTest()
                }
            }
        }

        stage("Static Code Analysis : Sonar"){
            steps{
                
                script{
                    def id= 'sonar'     
                    staticCodeAnalysis(id)
                }
            }
        }

        stage("Quality Gate Check : Sonar"){
            steps{
                
                script{
                    def id= 'sonar'     
                    qualityCheck(id)
                }
            }
        }

        stage("Maven Build : Maven"){
            steps{
                
                script{     
                    mavenBuild()
                }
            }
        }
    }
    
}
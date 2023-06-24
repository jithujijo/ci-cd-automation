pipeline{
    agent any

    stages{

        stage("Git Checkout"){
            steps{
                
                script{
                    git branch: 'main', url: 'https://github.com/jithujijo/ci-cd-automation.git'
                }
            }
        }
    }
    
}
def call(map stageParams){
    checkout scmGit(branches: [[name: stageParams.branch]], extensions: [], userRemoteConfigs: [[url: stageParams.url]])
}
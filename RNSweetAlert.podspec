Pod::Spec.new do |s|
  s.name         = "RNSweetAlert"
  s.version      = "3.1.0"
  s.summary      = "SweetAlert native library for React Native."
  s.homepage     = "https://github.com/Clip-sub/react-native-sweet-alert.git"
  s.license      = 'MIT'
  s.author       = {'Doko-Demo-Doa' => 'https://github.com/acaziasoftcom/react-native-sweet-alert'}
  s.source       = { :git => 'https://github.com/acaziasoftcom/react-native-sweet-alert.git',  :tag => "#{s.version}"}
  s.ios.deployment_target = '8.0'
  s.source_files = '*.swift'
  s.requires_arc = 'true'
end

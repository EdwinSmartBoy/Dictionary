# Dictionary
## dictionary
  Dictionary,中文翻译为字典，词典的意思，所以这个项目也是实现了字义查询的功能，当前只支持查询单个字体，因为查询字体的接口是使用了聚合数据的新华字典的接口，
  所以在使用的时候是只能查询单个字的解释。

## 项目中添加的依赖如下：
    // rxAndroid
    compile 'io.reactivex:rxandroid:1.2.0' 
    compile 'io.reactivex:rxjava:1.1.5'
    // Retrofit（需要gson + adapter-rxjava）
    compile 'com.squareup.retrofit2:retrofit:2.0.0-beta4'
    compile 'com.squareup.retrofit2:converter-gson:2.0.0-beta4'
    compile 'com.squareup.retrofit2:adapter-rxjava:2.0.0-beta4'
    
    项目只是一个很简单的demo，只是练习mvp框架与使用RxJava结合Retrofit网络框架的练习。项目没什么难得地方，自己是在边学边写，知道自己是菜鸟，所以请路过的大神不要喷小弟，

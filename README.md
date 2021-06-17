# PropertyApp
This app has two pages.

The main page (MainActivity) lists all properties in cards. 
1. Orientation change is supported. Since a ViewModel holds the liveData of property data, and the viewModel's lifecycle is longer than an activity's, the data ron't be redownloaded because of screen rotation. 
2. The programming language is Kotlin.
3. MVVM is applied. There are two activies represent views, and model here is an entity class called Data. The Data class's structure align to the Json structure. ViewModel holds data for UI. Repository is a Data warehouse, which manipulate all the data source, and all viewModels should interact with it. In this case, the json file is the only data source.  
4. Coroutine is employed to build http connection and read data on non-UI thread
5. I have't learned dependency injection, and I didn't explore it today due to time limitation. 
6. I tried two ways to send http request. First I use url.openConnection(), then I explored Retrofit. Both work. 
7. key funtions works, but time is limited to improve performance. I have to admit that image loading is slow.
8. Property' images are showed in a slidable widget. Due to permission denied, the first peoperty's picture are not available, and I haven't figured out how to pre detect if the links in ViewPager's adapter are invalid. If I use imageView to show a single image, and use a "picture not available" image as defualt display, this problem can be hidden. However, I think a scrowable widget is more closer to users' expectation. I noticed that there are many other open source tools may have better performance. I'll try them later.
9. Views in cardView are arranged in a constraintLayout, so it should fit most of mobile phone devices. 

The seond page (DetailActivity)
1. simply shows the property ID,
2. has a back home botton at top.



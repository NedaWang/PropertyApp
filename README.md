# PropertyApp
This app has two pages.

The main page (MainActivity) lists all properties in cards. 
1. Orientation change is supported. Since a ViewModel holds the liveData of property data, and the viewModel's lifecycle is longer than an activity's, the data won't be redownloaded because of screen rotation. 
2. The programming language is Kotlin.
3. MVVM is applied. There are two activities representing views, and the model here is an entity class called Data. The Data class's structure aligns with the JSON structure. ViewModel holds data for UI. Repository class is a Data warehouse, which manipulates all the data sources, and all viewModels should interact with it. In this case, the JSON file is the only data source.  
4. Coroutine is employed to build http connection and read data on non-UI thread
5. I haven't learned dependency injection, and I didn't explore it today due to time limitation. I will learn it later.
6. I tried two ways to send http request. First I use url.openConnection(), then I explored Retrofit. Both work. 
7. key functions work, but time is limited to improve performance. I have to admit that image loading is slow.
8. Property' images are displayed in a slidable widget. Due to permission denied, the first peoperty's pictures are not available, and I haven't figured out how to pre detect if the links in ViewPager's adapter are invalid. If I use imageView to show a single image, and use a "picture not available" image as defualt display, this problem can be hidden. However, I think a scrollable widget is more closer to users' expectations. I noticed that there are many other open-source tools may have better performance. I'll try them later.
9. Views in cardView are arranged in a constraintLayout, so it should fit most mobile phone devices. 

The second page (DetailActivity)
1. simply shows the property ID,
2. has a back home button at the top.



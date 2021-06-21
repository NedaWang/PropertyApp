# PropertyApp
This app shows properties' data. There are two pages. 


## Version 1:
####The main page (MainActivity) lists all properties in cards. 
1. Orientation change is supported. Since a ViewModel holds the liveData of property data, and the viewModel's lifecycle is longer than an activity's, the data won't be redownloaded because of screen rotation. 
2. The programming language is Kotlin.
3. MVVM is applied. Data structure align with the JSON structure. ViewModel holds data for UI. Repository class is a Data warehouse, which aims to manipulate all the data sources, and viewModels interact with it. In this case, the JSON file is the only data source.  
4. Coroutine is employed to build http connection and read data on non-UI thread
5. Dependency injection is applied. ProeretyAPI is injected in PropertyRepository. PropertyRepository is injected in ViewModel. ViewModel is injected into Activity.
6. There are two implementation of Http connection, Retrofit and url.openConnection(),both work. 
7. Property' images are displayed in a slidable widget. The image slider has an indicator to show how many pictures there are and which picture is displaying. Due to permission denied, the first peoperty's pictures are not available, and an error image is displayed instead. And it has a landing page as well. 
8. Views in cardView are arranged in a constraintLayout, so it should fit most mobile phone devices. 

####The second page (DetailActivity)
1. simply shows the property ID,
2. has a back home button at the top.

## Version 2:
Upgrade to single activity architecture, since the two pages share the same dataset. 
####ProperetyActivity binds a FragmentContainerView
1. PropertyListFragment shows cards of properties.
2. PropertyDetailFragment shows id of a selected property.
3. Fragments transaction is handled by Navigation Component.
4. Property Id is passed as Safe Args


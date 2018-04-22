# General information of the project:

- **Language**: Kotlin
- **IDE**: Android Studio
- **Version control**: GIT
- **Design Pattern**: MVP (Model - View - Presenter)

The project follows a feature structure, there is a feature folder where all additional features would be placed, in this example the feature provided is `AuctionsList`
Each feature manages its own views, presenters, and repositories, the access to them are provided through interfaces defined at the `Contract` interface at the feature folder level,
this way, any new method required by the given feature (in the view or in the presenter) should be added in the contract.

To create the network client communication I chose the library `Retrofit`, the calls to the different endpoints would be through the service interface so any additional feature that requires a new endpoint will be added here.

The management of the response is done with `RxJava`, using `Observables` in the the repository and `Subscription` in the `Presenter`.
This subscription is cleared when the view is destroyed in order to avoid memory leaks.

I decided to create one model for the Network Response and the one used through the project is `Auction`

I declared a `GsonFactoryClass` to initialize the `GSON` builder in order to save/retrieve the data in orientation change.
I declared a `AuctionUtils` service in order to process all the info related with the auctions (era, color background)

The Auctions are displayed in a  `RecyclerView ` in the main  `Activity `, this  `RecyclerView ` has 2 types of  `ViewHolders `, title, and item. So made it this way this list is escalable and could incorporate other kind of elements in case the designer choose it.

For the detail of the Auction I decided to implemnt a  `DialogFragment` that it is displayed over the List,

I provided a gamma of 7 colors in the colors.xml resource that are used through the project. I use 5 of them to give different colors to the background depending on the value of the risk band.
I provided internationalization for Spanish language.
I provide a `UnitTest` class of the presenter implemented.
I provide a `UITest` class of the view developed.

The gradle file has 2 build types, one for debug an other for production, both of them refer to the same API URL (this should be improved including signing options
for the production version)

# Scrum:
In order to manage this project I followed the principles of _Scrum Methodology_ identifying the following tasks and estimating them as follows:

- [x] **TaskA**: Setup the project -> Story Points: **3**
- [x] **TaskB**: Establish the MVP architecture & Network Calls -> Story Points: **5**
- [x] **TaskC**: Implement the adpater for the list -> Story Points: **8**
- [x] **TaskD**:  Create Auction Detail -> Story Points: **5**
- [x] **TaskE**: Internationalization -> Story Points: **1**
- [x] **TaskF**: UnitTest of the presenter -> Story Points: **2**
- [x] **TaskG**: UITest of the view -> Story Points: **3**

Other tasks identified not implemented:

- [ ] **TaskH**: Improve designs
- [ ] **TaskI**: Define custom styles for the app
- [ ] **TaskJ**: Implement `Dagger` to inject the presenter
- [ ] **TaskK**: Implement persistence for not network 
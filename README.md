# *News-Server* Reloaded Project Coordinator

This repository is for planning and coordinating development of all other child repositories of "News-Server Reloaded" project.

Initially the [News-Server](https://github.com/dasBikash84/NewsServer) app was launched as a standalone android app and it had no back end. That app fetches newspaper articles from 18 different newspapers and displays that. Now on this project, an effort has been made to add back-end to <strong>*News-Server*</strong> project. Hence it is named <strong>`News-Server Reloaded`</strong>.

Repositories under *News-Server Reloaded* are as below:

* [`Data Parser`](https://github.com/dasBikash84/News-Server-Parser-back-end-app): This is a console application written in Kotlin for Article data parsering from supported News-Paper sites.

* [`Parser REST service`](https://github.com/dasBikash84/news_server_parser_rest_end_point): Through this rest service the parser app provides endpoints to `data coordinator`app for settings and article data. Operation control and monitoring of parser app is also done via this rest service.

* [`Data Coordinator`](https://github.com/dasBikash84/news_server_data_coordinator): Console app (written in Kotlin) to synchronize settings and article data between `data parser`app and app data sources. It downloads settings and article data from the parser app via parser's `rest service`and uploads that data to app data sources.

* [`Data coordinator REST service`](https://github.com/dasBikash84/ns_reloaded_data_coordinator_jersey_rest_service): REST service 
for status monitoring and operation control of *Data Coordinator App*.

* [`Android app`](https://github.com/dasBikash84/News-Server-Android-Client): Front end android app.

Apart from the above mentioned repositories, `Firebase Real-Time Database` and `Firebase Firestore database` has been used as
remote data sources for this project.

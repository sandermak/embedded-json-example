Embedding JSON with server-side rendering
=========================================

This repository illustrates a technique outlined in the blog post ['blog title'](http://branchandbound.net/blog/). In short, it shows how you can have both a nice user experience (ie. no Ajax callback to wait for on after the initial render, Ajax requests for subsequent clicks in the page) without having to duplicate your rendering logic in both the server and the client. The trick is to embed the JSON of the initial data in your (server rendered) HTML. You can then use this embedded JSON in your client-side templating solution for the initial render, without an additional network-roundtrip.

There are three situations to try out:

1. [master branch](https://github.com/sandermak/embedded-json-example) contains the final embedded JSON example
2. [client-side-only](https://github.com/sandermak/embedded-json-example/tree/client-side-only) branch contains the same example with an initial Ajax callback on pageload to get the actual data (typical 'client-side MVC' approach)
3. [server-side-only](https://github.com/sandermak/embedded-json-example/tree/server-side-only) branch contains the same example using pure server-side rendering, no Ajax calls anywhere. Think 2001.

By switching between these branches you can quickly compare the approaches and how the different techniques affect the code base. For a quick overview:

- View the diff between [master and client-side-only](https://github.com/sandermak/embedded-json-example/compare/client-side-only)
- View the diff between [master and server-side-only](https://github.com/sandermak/embedded-json-example/compare/server-side-only)

Running the examples
--------------------

The examples are all based on a simple Spring MVC application template, using JSP for server-side rendering and JQuery for client-side work. You can build and run the examples using maven. Start them by executing:

    git checkout <branch-to-run>
    mvn tomcat7:run

After this, the application is available at http://localhost:8080/embedded-json-example/

Don't forget to restart Tomcat after switching branches, or the changes in the Java code won't be picked up! Use the developer console of your browser to see what happens. Note that I added a 400ms delay in the Ajax calls, to simulate a high-latency situation. The higher the latency, the more pronounced the difference is between the initial render of the master branch and the client-side-only branch.

More detailed motivation for this trick can be found at http://branchandbound.net/blog/


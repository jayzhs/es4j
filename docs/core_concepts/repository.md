# Repository

Repository is an entry point to most of end-user ES4J functionality.
It puts all components (journalling, indexing, querying) together.

```java
Repository repository = Repository.create();

Journal journal = new MemoryJournal();
repository.setJournal(journal);

IndexEngine indexEngine = new MemoryIndexEngine();
repository.setIndexEngine(indexEngine);

// ES4J should find commands and events in this
// hierarchy of packages:
repository.addCommandSetProvider(new PackageCommandSetProvider(new Package[]{getClass().getPackage()}));
repository.addEventSetProvider(new PackageEventSetProvider(new Package[]{getClass().getPackage()}));

repository.startAsync().awaitRunning();
```

Now we're ready to publish the command:

```java
User result = repository.publish(new CreateUser().email("foo@bar.com")).get();
```

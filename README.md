play-serviceclient
==================

Getting REST/WS client for all the PLAY services.

Usage :

```
PlayClient client = new PlayClient(registry);
TopicAware topicClient = client.getDSBTopicAware();
topicClient.add(topic);
```
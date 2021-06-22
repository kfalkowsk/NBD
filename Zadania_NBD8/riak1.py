import string
import riak

myClient = riak.RiakClient(pb_port=8087, protocol='pbc')

myBucket = myClient.bucket('NBD8')

anime = {"name" : "Bleach",
          "episodes" : 366,
          "genre": "n/a"
          "author" "n/a"}

newAnime = myBucket.new(anime['name'], data = anime)
newAnime.store()
print("Zapisano, key: " + myBucket.key + " | data = " + str(myBucket.data))

fetched1 = myBucket.get(newAnime.key)
print("Pobrano, key: " + fetched1.key + " | data = " + str(fetched1.data))

fetched2 = fetched1.data
fetched2["genre"] = "shounen"
fetched2["author"] = "Kubo Tite"
fetched1 = fetched2
fetched1.store()

fetched1 = myBucket.get(newAnime.key)
print("Pobrano zaktualizowane, key: " + fetched1.key + " | data = " + str(fetched1.data))

myBucket.delete(fetched1.key)
print("Proba pobrania usunieteg: " + fetched1.key + " | data = " + str(myBucket.get(fetched1).data))





package net.engineeringdigest.journalApp.Repository;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {
}

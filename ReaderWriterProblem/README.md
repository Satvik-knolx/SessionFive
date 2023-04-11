# Objective of the project

Implement a writers-preference reader-writer lock.
In the reader-writer problem we consider that some threads may read and some may write. We want to prevent more than one thread modifying the shared resource simultaneously and allow for two or more readers to access the shared resource at the same time.
Make sure that if there is a writer thread waiting then it should get access to the resource as soon as possible i.e. as soon as it is available for someone to acquire it.


## Readers-Writers-Problem

If two or more than two readers want to access the file at the same point in time there will be no problem. However, in other situations like when two writers or one reader and one writer wants to access the file at the same point of time, there may occur some problems, hence the task is to design the code in such a manner that if one reader is reading then no writer is allowed to update at the same point of time, similarly, if one writer is writing no reader is allowed to read the file at that point of time and if one writer is updating a file other writers should not be allowed to update the file at the same point of time.




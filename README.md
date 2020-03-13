# HOPSCOTCH HASHING
## A Implementation of the Hopscotch Hashing technique.

*************************************
### *Description*: 

*Hopscotch hashing is a scheme in computer programming for resolving hash collisions of values of hash functions in a table using open addressing.*

A Project for Advance Data Structures in B.E. Computer Science Course.
```
1.The idea of hopscotch hashing is to bound the maximal length of the probe sequence
by a predetermined constant that is optimized to the underlying computer’s architecture.

2.Let MAX_DIST be the chosen bound on the maximum probe sequence. This means
that item x must be found somewhere in the MAX_DIST positions listed in hash(x),
hash(x) + 1, . . . , hash(x) + (MAX_DIST − 1).

3.In order to efficiently process evictions,
we maintain information that tells for each position x, whether the item in the alternate
position is occupied by an element that hashes to position x.

Hopscotch hashing is a relatively new algorithm, but the initial experimental results are
very promising, especially for applications that make use of multiple processors and require
significant parallelism and concurrency. It remains to be seen if either cuckoo hashing or
hopscotch hashing emerge as a practical alternative to the classic separate chaining and
linear/quadratic probing schemes.
```
*****************************************
### *Programming Language*:

Java
*****************************************

### *Key functionality*: 
```
1. Insertion
2. Deletion
3. Searching
4. Hash Table
5. Search Table
```
**************************************

### *Running the code*:

```
1. Download the repository.
2. Open Netbeans IDE and go to Files menu and Select Import Project.
3. Choose "Import from ZIP", and search for the location where you saved the downloaded ZIP folder.
4. Select the folder and let it load.
5. Open the Run Package and run the file Hopscotch.java using "Shift+F6".
6. The different functionalities like insertion,deletion,etc. can be performed.
```
***************************************

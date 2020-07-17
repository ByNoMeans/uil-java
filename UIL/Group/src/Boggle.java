public class Boggle {

}

    //Given matrix/graph of letters, see if either
    // a) given list of words
    // b) the english dictionary
    //contain the scrambled words (if any) given the graph/matrix

    //To traverse and find every word, need to use Depth First Search (DFS) search algorithm
    //To validate the words, need to use a Trie data structure, a search tree where nodes = alphabetic letters;
    //Usually going to be non-binary (multiple words can have the same starting letters)

    //Algorithm:
    //Start at top left cell of matrix; add it to traversed nodes, then gather neighbors; starting from the top left +
    // first neighbor, add it to the list of nodes, then check if this is a valid combination, then check if it can
    // lead to others; then traverse these, first adding to visited nodes, then checking the combination, the adding to
    // list of visited nodes. Store all valid combinations.
    // When this procedure is finished for one letter, clear the visited nodes, then redo this procedure, this time
    // only adding your valid combination if is hasn't been stored already (However, if you used a set of type String,
    //it automatically ignores duplicates, so you don't have to worry about it)
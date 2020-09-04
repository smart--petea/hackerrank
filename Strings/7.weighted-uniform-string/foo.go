package m

func WeightedUniformStrings(s string, queries []int32) []string {
    var prevRune rune
    var weight int32
    var weights map[int32]bool = make(map[int32]bool)

    for _, currentRune := range s {
        if prevRune != currentRune {
            weight = 0
            prevRune = currentRune
        } 

        weight = weight + int32(currentRune) - 96
        weights[weight] = true
    }

    var result []string
    queries = queries[1:]
    for _, query := range queries {
        if _, exists := weights[query]; exists {
            result = append(result, "Yes") 
        } else {
            result = append(result, "No") 
        }
    }

    return result
}

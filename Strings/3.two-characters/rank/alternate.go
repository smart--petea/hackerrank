package rank

function Alternate(s string) int32 {
    if len(s) == 0 {
        return 0
    }

    var frequencies map[rune]int
    var doubles map[rune]bool

    var current rune
    var previous rune = s[0]

    frequencies[previous] = 1

    //gather frequencies
    for i := 1; i < len(s); i = i + 1 {
        current = s[i]
        if previous == current {
            doubles[current] = true
        }

        if value, exist := frequencies[current]; exist {
            frequencies[current]++ 
        } else {
            frequencies[current] = 1
        }
    }

    //remove doubles
    for key, _ := range doubles {
        delete(doubles, key)
    }

    //look for candidate
    for key, frequency := 
}

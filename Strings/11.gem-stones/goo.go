package g

func gemstones(arr []string) int32 {
    return Gemstones(arr)
}

func Gemstones(arr []string) int32 {
    var set, setI map[rune]bool

    set = StringToMap(arr[0])
    for i := 1; i < len(arr); i++ {
        setI  = StringToMap(arr[i])
        set = IntersectSets(set, setI)
    }

    return int32(len(set))
}

func StringToMap(s string) map[rune]bool{
    set := make(map[rune]bool)
    for _, r := range s {
        set[r] = true
    }

    return set
}

func IntersectSets(set0 map[rune]bool , set1 map[rune]bool) map[rune]bool {
    set := make(map[rune]bool)

    for r, _ := range set0 {
        if _, exists := set1[r]; exists {
            set[r] = true
        }
    }

    return set
}

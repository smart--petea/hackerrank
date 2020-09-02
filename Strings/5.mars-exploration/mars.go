package mars

func MarsExploration(s string) int32 {
    var count int32 = 0
    for i, c := range s {
        switch i % 3 {
        case 1: 
            if c != 'O' {
                count++
            }
        default:
            if c != 'S' {
                count++
            }
        }
    }

    return count
}

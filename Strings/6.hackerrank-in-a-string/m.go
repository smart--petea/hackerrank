package m

func HackerrankInString(s string) string {
    hackerrank := []rune("hackerrank")

    for _, r := range s {
        if r == hackerrank[0] {
            hackerrank = hackerrank[1:]

            if len(hackerrank) == 0 {
                return "YES"
            }
        }
    }

    return "NO"
}

type value = null | number // [1-9];
type cell_type = "user" | "soln"

type cell = { value : value, cellType : cell_type }
type store = { [cell_id: string]: cell }

import React, {useState, useRef} from "react"
import "./Cell.css"

export const Cell = () => {
  const [value, setValue] = useState();
  const [inEditMode, setInEditMode] = useState(false);
  const inputElement = useRef(null);

  return (
    <div
      className="cell"
      onClick={() => inputElement.current.focus()}
    >
      <input
        className="number-input underline"
        type="text"
        ref={inputElement}
        placeholder="_"
        onChange={e => setValue(e.target.value)}
        onFocus={() => setInEditMode(true)}
        onBlur={() => setInEditMode(false)}
      />
    </div>
  )
}

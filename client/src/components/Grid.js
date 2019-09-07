import React from "react"
import "./Grid.css"

export const Grid = () => {
  return (
    <div className="grid">
      {Array(81)
        .fill()
        .map((_, i) =>
          <div
            className="cell"
            key={`cell-${i}`}
            id={`cell-${i}`}
          />)
      }
    </div>
  )
};

import React from "react"
import "./Grid.css"

export const Grid = () => {
  return (
    <div className="root grid">
      {Array(9)
        .fill()
        .map((_, i) =>
          <div
            className="grid"
            key={`grid-${i}`}
          >
            {Array(9)
            .fill()
            .map((_, j) =>
              <div
                key={`cell-${i}-${j}`}
                id={`cell-${i}-${j}`}
                className="cell"
              />)
            }
          </div>)
      }
    </div>
  )
};

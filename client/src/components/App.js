import React from 'react';
import './App.css';
import { Grid } from './Grid';

export const App = () => {
  return (
    <div className="app">
      <header className="header"><span>Welcome to Sudoku!</span></header>
      <Grid />
    </div>
  );
}

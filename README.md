# 🎲 Dice Game - Java Swing Application

A fun and interactive dice game built with Java Swing featuring user authentication, leaderboards, and database integration.

## 🚀 Features

### 🎮 Core Gameplay
- Roll two virtual dice to get a target sum
- Select numbers (1-12) to match the dice sum
- Submit selections to check if they match the target
- Reset selections if needed
- Win by shutting all 12 boxes (selecting all numbers correctly)

### 👤 User System
- Secure login with username/password
- Sign up with name, username, email, and password
- Password confirmation during signup
- Username availability check

### 🏆 Leaderboards
- Top 5 high scores from all players
- Personal score history tracking

### 💻 Technical Components
- Custom rounded buttons
- Animated dice visualization
- MySQL database integration
- Responsive Swing UI

## 📋 How to Play

1. **Login or Sign Up**
   - Existing users: Enter credentials
   - New users: Complete registration form

2. **Game Rules**
   1. Roll the dice to get a target number
   2. Select numbers that either:
      - Match the dice sum exactly, OR
      - Form a set whose sum equals the dice result
   3. Submit your selection
   4. Correct selections lock those numbers
   5. Win by locking all 12 numbers!

3. **View Leaderboard**
   - Check top scores
   - Track your personal progress

## 🛠️ Installation

### Prerequisites
- Java 8+
- MySQL Server
- MySQL JDBC Driver

### Setup Steps
1. Clone the repository:
   git clone https://github.com/VJoshiAnkita/Java-Shut-the-box-game.git
   cd Java-Shut-the-box-game
   

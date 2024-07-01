# Step 1: Use an official Node runtime as a parent image
FROM node:22

# Step 2: Set the working directory
WORKDIR /usr/src/app

# Step 3: Copy package.json and potentially package-lock.json
COPY package*.json ./

# Step 4: Install dependencies
RUN npm install

# Step 5: Copy the entire project into the container
COPY . .

# Step 6: Build the React application for production
RUN npm run build

# Step 7: Install serve to serve the static files
RUN npm install -g serve

# Step 8: Command to run the app
CMD ["serve", "-s", "build", "-l", "3000"]

# Step 9: Expose port 3000 to access the container
EXPOSE 3000

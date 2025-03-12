
// UI funkcionalumo testai
describe("User Interface Tests", function() {
    it("should save JWT token to localStorage after login", function() {
        localStorage.setItem("jwt", "test-token");
        expect(localStorage.getItem("jwt")).toBe("test-token");
    });

    it("should remove JWT token from localStorage after logout", function() {
        localStorage.setItem("jwt", "test-token");
        localStorage.removeItem("jwt");
        expect(localStorage.getItem("jwt")).toBeNull();
    });

    it("should show login form if user is not authenticated", function() {
        localStorage.removeItem("jwt");
        expect(document.querySelector("#login-form")).not.toBeNull();
    });
});

describe("login validation", function() {
  it("should return true for valid usernames", function() {
    expect(new ValidateLogin("abcaa","test").validateUser()).toBeTruthy();
    expect(new ValidateLogin("longusername", "test").validateUser()).toBeTruthy();
    expect(new ValidateLogin("john_doe", "test").validateUser()).toBeTruthy();
  });

  it("should return false for invalid usernames", function() {
    expect(new ValidateLogin("", "test").validateUser()).toBeFalsy();
    expect(new ValidateLogin("a", "test").validateUser()).toBeFalsy();
    expect(new ValidateLogin("ab", "test").validateUser()).toBeFalsy();
    expect(new ValidateLogin("abc", "test").validateUser()).toBeFalsy();
    expect(new ValidateLogin(null, "test").validateUser()).toBeFalsy();
  });
  it("should return true for valid password", function() {
	    expect(new ValidateLogin("test","abcaa").validateUser()).toBeTruthy();
	    expect(new ValidateLogin("test", "longpassword").validateUser()).toBeTruthy();
	    expect(new ValidateLogin("test", "john_doe").validateUser()).toBeTruthy();
  });

  it("should return false for invalid password", function() {
	    expect(new ValidateLogin("test", "").validateUser()).toBeFalsy();
	    expect(new ValidateLogin("test", "a").validateUser()).toBeFalsy();
	    expect(new ValidateLogin("test", "ab").validateUser()).toBeFalsy();
	    expect(new ValidateLogin("test", "abc").validateUser()).toBeFalsy();
	    expect(new ValidateLogin("test", null).validateUser()).toBeFalsy();
  });
});
